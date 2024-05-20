package com.lkcoffee.exception;

import com.lkcoffee.exception.BaseException;

public class DeletionNotAllowedException extends BaseException {

    public DeletionNotAllowedException(String msg) {
        super(msg);
    }

}
