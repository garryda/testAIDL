package com.example.testaidl;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {

    //对象的属性
    public int bookId;
    public String bookName;

    //空的构造函数
    public Book() {

    }

    //进行赋值的构造函数
    public Book(int bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    //描述内容的方法，大多数都直接返回0，只有有文件描述符的时候才返回1
    public int describeContents() {
        return 0;
    }

    //将当前对象写入序列化结构中，其中flags为0或者1，1代表标志当前
    //对象需要作为返回值返回，不可以立即释放资源，几乎所有情况都为0
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(bookId);
        out.writeString(bookName);
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        //从序列化的对象创建原始对象
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        //创建指定长度的原始对象数组
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    //进行反序列化的方法
    private Book(Parcel in) {
        bookId = in.readInt();
        bookName = in.readString();
    }

    @Override
    public String toString() {
        return String.format("[bookId:%s, bookName:%s]", bookId, bookName);
    }

}
