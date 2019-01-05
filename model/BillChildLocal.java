package com.bimart.database.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "billchild",
        foreignKeys = {
                @ForeignKey(
                        entity = BillLocal.class,
                        parentColumns = "id",
                        childColumns = "bill_id"
                )
        },
        indices = {@Index("bill_id")}
)
public class BillChildLocal {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_billchild")
    public int id_billchild;
    @ColumnInfo(name = "journal_id")
    public int journal_id;
    @ColumnInfo(name = "journal_name")
    public String journal_name;
    @ColumnInfo(name = "price")
    public long price;
    @ColumnInfo(name = "bill_id")
    public int bill_id;

    public BillChildLocal() {
    }

    @Ignore
    public BillChildLocal(int journal_id, String journal_name, long price, int bill_id) {
        this.journal_id = journal_id;
        this.journal_name = journal_name;
        this.price = price;
        this.bill_id = bill_id;
    }
}
