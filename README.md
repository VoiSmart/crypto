# Crypto

This is a simple library to encrypt and decrypt small amount of data such as passwords. 

#### Features
 * Supports down to Android API 18
 * Exposes only two methods: `Encrypt` and `Decrypt`
 * No useless boilerplate
 * Uses AndroidKeyStore to store the keys
 * Fixed cryptographic algorithms
   + `RSA` for `18 <= API <= 22` and optionally also for `API >= 23` (if you set `forceAsymmetric = true` in initialization))
   + `AES` for `API >= 23`

## Usage
 * Init the library
```kotlin
Crypto.init(context, "keys_alias")
```
 * Use the library
```kotlin
val helper = EncryptionHelper.getInstance()
val encrypted = helper.encrypt("some_text")
val decrypted = helper.decrypt(encrypted)
```

## Future
 * More init configuration
   + Algorithm
   + Provider
   + Transformation
 * Resiliency to AndroidKeyStore keys deletion
 * Recover from exception
 * Other features I'm not yet aware

## Notice
On API level lower than 21 keys might be deleted when user change the display's security mechanism (screen lock)
Use with caution and only if losing your keys or not being able to recover the encrypted data are not critical for you.

## Acknowledgement
Parts of the code are freely inspired by the [Security Workshop Sample](https://github.com/temyco/security-workshop-sample.git)