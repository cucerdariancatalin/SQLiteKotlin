package com.andtest.utopiacities

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.andtest.utopiacities.db.ContractClass
import com.andtest.utopiacities.db.DatabaseOpenHelper
import org.junit.After

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    lateinit var dbOpenHelper: DatabaseOpenHelper

    @Before
    fun setup() {
        dbOpenHelper = DatabaseOpenHelper(InstrumentationRegistry.getInstrumentation().targetContext)
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.andtest.utopiacities", appContext.packageName)
    }

    @Test
    fun getCount() {
        val countQuery = "SELECT  * FROM ${ContractClass.City.TABLE_NAME}"
        val db: SQLiteDatabase = dbOpenHelper.readableDatabase
        val cursor: Cursor = db.rawQuery(countQuery, null)
        val count: Int = cursor.count
        cursor.close()
        assertEquals(count, 272128)
    }

    @After
    fun tearDown() {
        dbOpenHelper.close()
    }
}
