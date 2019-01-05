package com.bimart.database.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/*create by tusinh  on 10/3/2018*/

@Entity(tableName = "product",
        foreignKeys = {
                @ForeignKey(
                        entity = BillLocal.class,
                        parentColumns = "id",
                        childColumns = "bill_id"
                )
        },
        indices = {@Index("bill_id")})
public class ProductLocal {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;
    @ColumnInfo(name = "product_id")
    public int mProduct_id;
    @ColumnInfo(name = "product_name")
    public String mProduct_name;
    @ColumnInfo(name = "product_price")
    public long mProduct_price;
    @ColumnInfo(name = "product_quatity")
    public int mProduct_quatity;
    @ColumnInfo(name = "product_code")
    public String mProduct_code;
    @ColumnInfo(name = "product_discount")
    public float mProduct_discount;

    @ColumnInfo(name = "stock_production_name")
    public String stock_production_name;
    @ColumnInfo(name = "tracking")
    public String tracking;
    @ColumnInfo(name = "isByLot")
    public boolean isByLot ;
    @ColumnInfo(name = "isActionOkLot")
    public boolean isActionOkLot;
    @ColumnInfo(name = "stock_promotion")
    public String stock_promotion = "";

    @ColumnInfo(name = "bill_id")
    public int bill_id;

    public ProductLocal() {
    }

//    public ProductLocal(@NonNull int mProduct_id, String mProduct_name, long mProduct_price, int mProduct_quatity, String mProduct_code, float mProduct_discount, int stock_production_id, String stock_production_name, String tracking, boolean isByLot, boolean isActionOkLot, String stock_promotion, int bill_id) {
//        this.mProduct_id = mProduct_id;
//        this.mProduct_name = mProduct_name;
//        this.mProduct_price = mProduct_price;
//        this.mProduct_quatity = mProduct_quatity;
//        this.mProduct_code = mProduct_code;
//        this.mProduct_discount = mProduct_discount;
//        this.stock_production_id = stock_production_id;
//        this.stock_production_name = stock_production_name;
//        this.tracking = tracking;
//        this.isByLot = isByLot;
//        this.isActionOkLot = isActionOkLot;
//        this.stock_promotion = stock_promotion;
//        this.bill_id = bill_id;
//    }

    @Ignore
    public ProductLocal(@NonNull int mProduct_id, String mProduct_name, long mProduct_price, int mProduct_quatity, String mProduct_code, float mProduct_discount, int bill_id) {
        this.mProduct_id = mProduct_id;
        this.mProduct_name = mProduct_name;
        this.mProduct_price = mProduct_price;
        this.mProduct_quatity = mProduct_quatity;
        this.mProduct_code = mProduct_code;
        this.mProduct_discount = mProduct_discount;
        this.bill_id = bill_id;
    }
}
