package com.example

import java.sql.Connection
import java.sql.DriverManager

fun main() {
    println("turuuru wonsz rzeczny")
        
    connectToDatabase()
}

fun connectToDatabase() {
    var connection: Connection? = null
    
    try {        
        connection = DriverManager.getConnection("jdbc:sqlite::memory:")
        
        println("Pomyślnie połączono z bazą danych SQLite")
                
        val statement = connection.createStatement()
        statement.execute("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, name TEXT NOT NULL)")
                
        statement.execute("INSERT INTO users (name) VALUES ('Testowy Użytkownik')")
                
        val resultSet = statement.executeQuery("SELECT * FROM users")
        while (resultSet.next()) {
            println("Odczytano użytkownika: ID=${resultSet.getInt("id")}, Nazwa=${resultSet.getString("name")}")
        }
        
    } catch (e: Exception) {
        println("Błąd podczas pracy z bazą danych: ${e.message}")
    } finally {
        connection?.close()
    }
}