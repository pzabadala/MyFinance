package com.zabadala.finance.myfinance.services;

/**
 * Created by pzaba on 2017-11-26.
 */

public enum DbServiceEnum {
     ADD_TRANSACTION(1),
     GET_TRANSACTION(2);

     DbServiceEnum(int value){
         this.value = value;

     }
     final private int value;
     final public int getValue(){
         return value;
     }
}
