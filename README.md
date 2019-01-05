# RoomDatabase-Android
* use SqlLite android to see data.
# How to use
* use like your package
1. get instance
```java
  appDatabase = AppDatabase.getInstance(AddSellActivity.this);
```
2. Example insert :
```java
         long time = System.currentTimeMillis();

                                    Calendar calendar = Calendar.getInstance();
                                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                                    String date_hour = simpleDateFormat.format(calendar.getTime());

                                    BillLocal billlocal = new BillLocal(
                                            SharedPref.getString(addSellActivity, SharedPref.NAME),
                                            "bill" + time,
                                            addSellActivity.totalMoney(),
                                            addSellActivity.partner.id,
                                            addSellActivity.partner.name,
                                            addSellActivity.sourceob.id,
                                            addSellActivity.sourceob.name,
                                            date_hour);
                                    long[] bill_id = addSellActivity.appDatabase.billDao().insertBill(billlocal);

                                    if (addSellActivity.arrayListProductInCreateSell.size() > 0) {
                                        for (int i = 0; i < addSellActivity.arrayListProductInCreateSell.size(); i++) {
                                            Product product = addSellActivity.arrayListProductInCreateSell.get(i);
                                            ProductLocal productLocal = new ProductLocal(
                                                    product.id,
                                                    product.name,
                                                    product.price,
                                                    product.quatity,
                                                    product.code,
                                                    product.discount,
                                                    (int) bill_id[0]
                                            );
                                            // update roomdatabase after have ctkm
                                            if(!product.stock_production.equals("")){
                                                productLocal.stock_production_name = product.stock_production;
                                            }else {
                                                productLocal.stock_production_name = "null";
                                            }
                                            productLocal.tracking=product.tracking;
                                            productLocal.isByLot=product.isByLot;
                                            productLocal.isActionOkLot=product.isActionOkLot;
                                            productLocal.stock_promotion=product.stock_promotion;
                                            // update roomdatabase after have ctkm

                                            addSellActivity.appDatabase.productDao().insertProduct(productLocal);
                                        }
                                    }

                                    if (addSellActivity.arrayListOrderCheckout.size() > 0) {
                                        for (int i = 0; i < addSellActivity.arrayListOrderCheckout.size(); i++) {
                                            OrderCheckoutModel orderCheckoutModel = addSellActivity.arrayListOrderCheckout.get(i);
                                            BillChildLocal billChildLocal = new BillChildLocal(
                                                    orderCheckoutModel.journal.id,
                                                    orderCheckoutModel.journal.name,
                                                    orderCheckoutModel.price,
                                                    (int) bill_id[0]
                                            );
                                            addSellActivity.appDatabase.billChildDao().insertBillChild(billChildLocal);
                                        }
                                    }
                                    addSellActivity.finish();
```
3. Example update:
```java
    addSellActivity.appDatabase.billDao().
                        updateBillPartner(
                                addSellActivity.partner_in_createOrderTemp.id,
                                addSellActivity.partner_in_createOrderTemp.name,
                                addSellActivity.bill_idlocal);
                addSellActivity.appDatabase.billDao().updateBillSource(
                        addSellActivity.sourceob_in_createOrderTemp.id,
                        addSellActivity.sourceob_in_createOrderTemp.name,
                        addSellActivity.bill_idlocal
                );
                addSellActivity.appDatabase.billDao().updateBillTotalMoney(
                        addSellActivity.totalMoneyInCreateOrderTemp(),
                        addSellActivity.bill_idlocal
                );
```
