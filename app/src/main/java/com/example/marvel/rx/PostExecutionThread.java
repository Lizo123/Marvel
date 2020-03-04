package com.example.marvel.rx;

import io.reactivex.Scheduler;

public interface PostExecutionThread {
    /**
     * PostExecutionThread returns Schedular which is a tool that we can use for scheduling individual actions.
     */
    Scheduler getScheduler();

}
