class SQLCipherHelper(context: Context,
                              databaseDefinition: DBFlowDatabase,
                              callback: DatabaseCallback?,
                      override val cipherSecret: String)
    : SQLCipherOpenHelper(context, databaseDefinition, callback)
