package com.dodolife.jadwalsholat.database.dao

import androidx.room.*

interface BaseDao<in X> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertx(obj: X)

    @JvmSuppressWildcards
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(obj: List<X>)

    @JvmSuppressWildcards
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertIgnore(obj: List<X>)

    @Update
    fun update(obj: X)

    @JvmSuppressWildcards
    @Update
    fun update(obj: List<X>)

    @Delete
    fun delete(obj: X)
}