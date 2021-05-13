package com.by.petranovski.patterns.myObservable.interfaces;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HttpRatesRequest {

    private double eur;
    private double usd;
    private double rus;
}
