package com.hendisantika.books.test

import org.dbunit.database.DatabaseConnection
import org.dbunit.dataset.csv.CsvDataSet
import org.dbunit.operation.DatabaseOperation
import org.junit.rules.ExternalResource
import org.springframework.beans.factory.annotation.Autowired
import java.io.File
import javax.sql.DataSource

/**
 * Created by hendisantika on 24/01/17.
 */
class TestDataResources : ExternalResource() {
    @Autowired
    lateinit private var dataSource: DataSource

    override fun before() {
        var con: DatabaseConnection? = null
        try {
            // テストデータのインサート
            con = DatabaseConnection(dataSource.connection)
            DatabaseOperation.CLEAN_INSERT.execute(con!!, CsvDataSet(File("src/test/resources/testData")))
        }finally{
            con?.close()
        }
    }

    override fun after() {
        // 特にやることがない
    }
}