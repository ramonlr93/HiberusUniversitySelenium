package com.hiberus.university.selenium.utils;

// Licensed to the Software Freedom Conservancy (SFC) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The SFC licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.time.Clock;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.Wait;

/**
 * An implementation of the {@link Wait} interface that may have its timeout and polling interval
 * configured on the fly.
 * <p>
 * <p>
 * Each FluentWait instance defines the maximum amount of time to wait for a condition, as well as
 * the frequency with which to check the condition. Furthermore, the user may configure the wait to
 * ignore specific types of exceptions whilst waiting, such as
 * {@link org.openqa.selenium.NoSuchElementException NoSuchElementExceptions} when searching for an
 * element on the page.
 * <p>
 * <p>
 * Sample usage: <pre>
 *   // Waiting 30 seconds for an element to be present on the page, checking
 *   // for its presence once every 5 seconds.
 *   Wait&lt;WebDriver&gt; wait = new FluentWait&lt;WebDriver&gt;(driver)
 *       .withTimeout(30, SECONDS)
 *       .pollingEvery(5, SECONDS)
 *       .ignoring(NoSuchElementException.class);
 * <p>
 *   WebElement foo = wait.until(new Function&lt;WebDriver, WebElement&gt;() {
 *     public WebElement apply(WebDriver driver) {
 *       return driver.findElement(By.id("foo"));
 *     }
 *   });
 * </pre>
 * <p>
 * <p>
 * <em>This class makes no thread safety guarantees.</em>
 *
 * @param <T> The input type for each condition used with this instance.
 */
public class MyFluentWait<T> implements Wait<T>
{

    public static final Duration FIVE_HUNDRED_MILLIS = Duration.of(500, ChronoUnit.MILLIS);

    private final T input;
    private final Clock clock;
    private final Sleeper sleeper;

    private Duration timeout = FIVE_HUNDRED_MILLIS;
    private Duration interval = FIVE_HUNDRED_MILLIS;
    private Supplier<String> messageSupplier = () -> null;

    private List<Class<? extends Throwable>> ignoredExceptions = Lists.newLinkedList();

    /**
     * @param input The input value to pass to the evaluated conditions.
     */
    public MyFluentWait(T input)
    {
        this(input, Clock.systemDefaultZone(), Sleeper.SYSTEM_SLEEPER);
    }

    /**
     * @param input   The input value to pass to the evaluated conditions.
     * @param clock   The clock to use when measuring the timeout.
     * @param sleeper Used to put the thread to sleep between evaluation loops.
     */
    public MyFluentWait(T input, Clock clock, Sleeper sleeper)
    {
        this.input = checkNotNull(input);
        this.clock = checkNotNull(clock);
        this.sleeper = checkNotNull(sleeper);
    }

    /**
     * Sets how long to wait for the evaluated condition to be true. The default timeout is
     * {@link #FIVE_HUNDRED_MILLIS}.
     *
     * @param duration The timeout duration.
     * @param unit     The unit of time.
     * @return A self reference.
     */
    public MyFluentWait<T> withTimeout(long duration, ChronoUnit unit)
    {
        this.timeout = Duration.of(duration, unit);
        return this;
    }

    /**
     * Sets the message to be displayed when time expires.
     *
     * @param message to be appended to default.
     * @return A self reference.
     */
    public MyFluentWait<T> withMessage(final String message)
    {
        this.messageSupplier = () -> message;
        return this;
    }

    /**
     * Sets the message to be evaluated and displayed when time expires.
     *
     * @param messageSupplier to be evaluated on failure and appended to default.
     * @return A self reference.
     */
    public MyFluentWait<T> withMessage(Supplier<String> messageSupplier)
    {
        this.messageSupplier = messageSupplier;
        return this;
    }

    /**
     * Sets how often the condition should be evaluated.
     * <p>
     * <p>
     * In reality, the interval may be greater as the cost of actually evaluating a condition function
     * is not factored in. The default polling interval is {@link #FIVE_HUNDRED_MILLIS}.
     *
     * @param duration The timeout duration.
     * @param unit     The unit of time.
     * @return A self reference.
     */
    public MyFluentWait<T> pollingEvery(long duration, TemporalUnit unit)
    {
        this.interval = Duration.of(duration, unit);
        return this;
    }

    /**
     * Configures this instance to ignore specific types of exceptions while waiting for a condition.
     * Any exceptions not whitelisted will be allowed to propagate, terminating the wait.
     *
     * @param types The types of exceptions to ignore.
     * @param <K>   an Exception that extends Throwable
     * @return A self reference.
     */
    public <K extends Throwable> MyFluentWait<T> ignoreAll(Collection<Class<? extends K>> types)
    {
        ignoredExceptions.addAll(types);
        return this;
    }

    /**
     * @param exceptionType exception to ignore
     * @return a self reference
     * @see #ignoreAll(Collection)
     */
    public MyFluentWait<T> ignoring(Class<? extends Throwable> exceptionType)
    {
        return this.ignoreAll(ImmutableList.<Class<? extends Throwable>>of(exceptionType));
    }

    /**
     * @param firstType  exception to ignore
     * @param secondType another exception to ignore
     * @return a self reference
     * @see #ignoreAll(Collection)
     */
    public MyFluentWait<T> ignoring(Class<? extends Throwable> firstType, Class<? extends Throwable> secondType)
    {

        return this.ignoreAll(ImmutableList.of(firstType, secondType));
    }

    /**
     * Repeatedly applies this instance's input value to the given function until one of the following
     * occurs:
     * <ol>
     * <li>the function returns neither null nor false</li>
     * <li>the function throws an unignored exception</li>
     * <li>the timeout expires</li>
     * <li>the current thread is interrupted</li>
     * </ol>
     *
     * @param <V>    The function's expected return type.
     * @return The function's return value if the function returned something different
     * from null or false before the timeout expired.
     * @throws TimeoutException If the timeout expires.
     */
    @Override
    public <V> V until(Function<? super T, V> isTrue)
    {
        long end = Clock.offset(clock, timeout).millis();
//        long end = clock.laterBy(timeout.in(MILLISECONDS));

        Throwable lastException;
        while (true)
        {
//            System.out.printf(">>> MFW trying...\n");

            try
            {
                V value = isTrue.apply(input);
                if (value != null && (Boolean.class != value.getClass() || Boolean.TRUE.equals(value)))
                {
//                    System.out.printf(">>> MFW returning value: %s\n", value.toString());
                    return value;
                }

                // Clear the last exception; if another retry or timeout exception would
                // be caused by a false or null value, the last exception is not the
                // cause of the timeout.
                lastException = null;
            }
            catch (Throwable e)
            {
                lastException = propagateIfNotIgnored(e);
            }

            // Check the timeout after evaluating the function to ensure conditions
            // with a zero timeout can succeed.
//            if (!clock.isNowBefore(end))
            if (!(System.currentTimeMillis() < end))
            {
                String message = messageSupplier != null ? messageSupplier.get() : null;

                String timeoutMessage = String.format("Expected condition failed: %s (tried for %d second(s) with %s interval)",
                        message == null ? "waiting for " + isTrue : message, timeout.getSeconds(), interval);
//                System.out.printf(">>> MFW: %s\n", timeoutMessage);

                throw timeoutException(timeoutMessage, lastException);
            }

            try
            {
//                System.out.printf(">>> MFW sleeping...\n");
                sleeper.sleep(interval);
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
                throw new WebDriverException(e);
            }
        }
    }

    private Throwable propagateIfNotIgnored(Throwable e)
    {
        for (Class<? extends Throwable> ignoredException : ignoredExceptions)
        {
            if (ignoredException.isInstance(e))
            {
                return e;
            }
        }
        Throwables.throwIfUnchecked(e);
        throw new RuntimeException(e);
    }

    /**
     * Throws a timeout exception. This method may be overridden to throw an exception that is
     * idiomatic for a particular test infrastructure, such as an AssertionError in JUnit4.
     *
     * @param message       The timeout message.
     * @param lastException The last exception to be thrown and subsequently suppressed while waiting
     *                      on a function.
     * @return Nothing will ever be returned; this return type is only specified as a convenience.
     */
    protected RuntimeException timeoutException(String message, Throwable lastException)
    {
        throw new TimeoutException(message, lastException);
    }
}
