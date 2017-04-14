package com;

import java.io.Serializable;

public enum Status implements Serializable{
    WAS_READ, WAS_WATCHED, WAS_LISTENED, WANT_TO_READ, WANT_TO_WATCH, WANT_TO_LISTEN, IN_PROGRESS;
}
