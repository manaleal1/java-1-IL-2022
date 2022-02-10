package com.example.java1il2022.week4.day18;

/**
 *  1. encoding + decoding vs encryption + decryption
 *     ASCII 0 - 127 standard ascii characters a - z 0 - 9 !@#?
 *     bit(128) ->
 *
 *     Symmetric encryption -> same key
 *     Asymmetric encryption -> public key + private key
 *                              public key encrypt -> private key decrypt
 *                              public key decrypt <- private key encrypt
 *  2. text 100KB -> encoding(text) 130KB
 */


/**
 *  1. HTTPS = Http + SSL / TLS
 *
 *                        Certificate Authority (CA)
 *        user             hello       ->                       server(certification, private key)
 *                        certification <-
 *       public key
 *  gen  random string      public key[random string]  ->
 *                        <-  hash string
 *                     generate symmetric key based on string
 *  2. authentication : username / password / code / email / phone text -> 401
 *                      token
 *  3. authorization : role based verification
 *                      JWT token {
 *                          user basic info
 *                          role info
 *                          expiration time
 *                      }
 *                    header.payload.signature
 *                    encode[header.payload.encryption[header.payload]]
 *  4. sql injection / xml injection
 *  5. hash(password)
 *  6. DDOS
 *  7. CSRF
 */


/**
 *  filter vs interceptor
 *
 *   request -> filter ->   dispatcher servlet -> handler mapping -> interceptor -> controller
 *                                  |
 *                          http message converter
 *  request -> authorization filter -> authentication filter -> dispatcher servlet -> ..-> controller -> service
 *
 *  Thread1 -> ThreadLocal
 *  Thread2 -> ThreadLocal
 *
 *
 *
 *
 */