package com.bimart.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.bimart.database.model.BillLocal;

import java.util.List;


@Dao
public interface BillDao {
    @Query("SELECT * FROM bill")
    List<BillLocal> getAllBill();

    @Query("DELETE FROM bill")
    void deleteAllBill();

    @Query("DELETE FROM bill WHERE id=:id")
    void deleteBillWithId(int id);

    @Query("UPDATE bill SET total_money=:total_money WHERE id=:id")
    void updateBillTotalMoney(long total_money, int id);

    @Query("UPDATE bill SET partner_id=:partner_id,partner_name=:partner_name WHERE id=:id")
    void updateBillPartner(int partner_id, String partner_name, int id);

    @Query("UPDATE bill SET source_id=:source_id,source_name=:source_name WHERE id=:id")
    void updateBillSource(int source_id, String source_name, int id);


    @Insert
    long[] insertBill(BillLocal... bills);
//    @Insert
//    void insertBill(BillLocal... bills);

    @Delete
    void deleteBill(BillLocal bill);

    @Update
    void updateBill(BillLocal... bills);
}
