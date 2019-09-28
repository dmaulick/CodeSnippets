private fun createDbFlowConfig(cipherSecret: String, context: Context): FlowConfig? {
        return try {
            FlowConfig.Builder(context)
                    .database(
                            DatabaseConfig.Builder(AppDatabase::class)
                                        { db, callback -> SQLCipherHelper(context, db, callback, cipherSecret) }
                                    .databaseName("AppDatabase") // This will load 'AppDatabase.db' located in your assets folder
                                    .build())
                    .openDatabasesOnInit(true)
                    .build()
        }
        catch (e: Exception) {
            Timber.e("Encrypted AppDatabase config could not be created using key $cipherSecret ")
            Timber.e(e)
            null
        }
    }
