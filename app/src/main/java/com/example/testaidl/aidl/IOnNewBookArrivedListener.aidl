package com.example.testaidl.aidl;

import com.example.testaidl.aidl.Book;

interface IOnNewBookArrivedListener {
    void onNewBookArrived(in Book newBook);
}
