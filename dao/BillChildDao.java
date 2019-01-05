package com.bimart.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.bimart.database.model.BillChildLocal;

import java.util.List;

@Dao
public interface BillChildDao {

    @Query("SELECT * FROM billchild")
    List<BillChildLocal> getAllBillChild();

    @Query("DELETE FROM billchild")
    void deleteAllBillChild();

    @Query("SELECT * FROM billchild WHERE bill_id=:bill_id")
    List<BillChildLocal> getAllBillChildWithBillId(int bill_id);

    @Query("DELETE FROM billchild WHERE bill_id=:bill_id")
    void deleteBillChildWithBillId(int bill_id);

    @Insert
    long[] insertBillChild(BillChildLocal... billchilds);
//    @Insert
//    void insertBill(BillLocal... bills);

    @Delete
    void deleteBillChild(BillChildLocal billChild);

    @Update
    void updateBillChild(BillChildLocal... billchilds);
}
