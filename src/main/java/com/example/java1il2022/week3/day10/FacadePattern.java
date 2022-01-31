package com.example.java1il2022.week3.day10;

/**
 *              user
 *              ||
 *            facade (log, security) - gateway
 *           /      \
 *        place1   place2
 *
 *
 *        class {
 *            public Object execute(String name, Object data) {
 *                switch(name) {
 *                    case "payment"
 *                         return PaymentService.execute(data);
 *                }
 *            }
 *        }
 *
 */
