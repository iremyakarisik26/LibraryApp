package com.libraryapp.libraryapp.services.impl;

import com.libraryapp.libraryapp.services.IDepositsService;

public class DepositsServiceImpl implements IDepositsService {
    private DepositsService depositsService;

    public DepositsServiceImpl(DepositsService depositsService) {
        this.depositsService = depositsService;
    }

}
