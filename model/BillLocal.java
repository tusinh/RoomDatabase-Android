package com.bimart.database.model;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Relation;
import android.support.annotation.NonNull;

import java.util.List;

/*create by tusinh on 10/3/2018*/
@Entity(tableName = "bill")
public class BillLocal {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;
    @ColumnInfo(name = "user")
    public String user;
    @ColumnInfo(name = "name_bill")
    public String name_bill;
    @ColumnInfo(name = "total_money")
    public long total_money;
    @ColumnInfo(name = "partner_id")
    public int partner_id;
    @ColumnInfo(name = "partner_name")
    public String partner_name;
    @ColumnInfo(name = "source_id")
    public int source_id;
    @ColumnInfo(name = "source_name")
    public String source_name;

    @ColumnInfo(name = "datehour_bill")
    public String datehour_bill;


    public BillLocal() {

    }

    @Ignore
    public BillLocal(String user, String name_bill, Long total_money, int partner_id, String partner_name,int source_id,String source_name, String datehour_bill) {
        this.user = user;
        this.name_bill = name_bill;
        this.total_money = total_money;
        this.partner_id = partner_id;
        this.partner_name = partner_name;
        this.source_id=source_id;
        this.source_name=source_name;
        this.datehour_bill = datehour_bill;
    }
}
