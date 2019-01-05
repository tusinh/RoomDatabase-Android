package com.bimart.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.bimart.database.model.ProductLocal;

import java.util.List;
/*create by tusinh  on 10/3/2018*/

@Dao
public interface ProductDao {

    @Query("SELECT * FROM product")
    List<ProductLocal> getAllProduct();

    @Query("SELECT * FROM product WHERE bill_id=:bill_id")
    List<ProductLocal> getAllProductWithBill_ID(int bill_id);

    @Query("UPDATE product SET product_quatity=:product_quatity WHERE id=:id")
    void updateProductQuatity(int product_quatity, int id);

    @Query("UPDATE product SET stock_production_name=:stock_production_name WHERE id=:id")
    void updateProductStockProduction(String stock_production_name, int id);

    @Query("UPDATE product SET stock_promotion=:stock_promotion WHERE id=:id")
    void updateProductStockPromotion(String stock_promotion, int id);

    @Query("UPDATE product SET isActionOkLot=:isActionOkLot WHERE id=:id")
    void updateProductisActionOkLot(boolean isActionOkLot, int id);

    @Query("UPDATE product SET isByLot=:isByLot WHERE id=:id")
    void updateProductisByLot(boolean isByLot, int id);

    @Query("UPDATE product SET product_price=:product_price,product_name=:product_name,isByLot=:isByLot,stock_production_name=:stock_production_name WHERE id=:id")
    void updateProductAfterCalucatePromotion(long product_price,String product_name,boolean isByLot,String stock_production_name, int id);

    @Query("UPDATE product SET product_discount=:product_discount WHERE id=:id")
    void updateProductDiscount(float product_discount, int id);

    @Query("DELETE FROM product WHERE id=:id")
    void deleteProductWithId(int id);

    @Query("DELETE FROM product WHERE bill_id=:bill_id")
    void deleteProductWithBillId(int bill_id);

    @Query("DELETE FROM product")
    void deleteAllProduct();

    @Insert
    long[] insertProduct(ProductLocal... products);

    @Delete
    void deleteProduct(ProductLocal product);

    @Update
    void updateProduct(ProductLocal... products);
}
