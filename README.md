# Chocolate-store
## The Problem

There is a chocolate store that sells white, dark, milk and sugar free chocolate bars. When a shopper places an order for chocolate, store staff specify the price of the chocolate and the number of wrappers that must be returned in order to receive free chocolates. The price of the chocolate and the number of wrappers required to receive a free chocolate changes with every order as the shop is still experimenting with how the promotion should work.

### Promotion Rules

- When a shopper trades the required number of:
  - `milk` wrappers they will receive one complimentary `milk` chocolate and one complimentary `sugar free` chocolate.
  - `white` wrappers they will receive one complimentary `white` chocolate and one complimentary `sugar free` chocolate.
  - `sugar free` wrappers they will receive one complimentary `sugar free` chocolate and one complimentary `dark`
  chocolate.
  - `dark` wrappers they will receive one complimentary `dark` chocolate.

### The Orders File

Orders placed by different shoppers can be found in the CSV file `input/orders.csv`. The first line of this file
contains header information, each subsequent line represents an order. The header format is:

    cash, price, wrappers needed, type

- Cash: the amount of cash the shopper has to spend on chocolate.

- Price: the price of a single chocolate.

- Wrappers needed: is the number of wrappers that must be traded in, in order to receive free chocolate. This number
applies to all chocolates irrespective of its type.

- Type: the type of chocolate the shopper is buying in that order.

There are four orders in the `input/orders.csv` file. Every line in `input/orders.csv` is a separate order with a
different `price` and number of `wrappers needed`. Orders are independent of each other, the `cash`, `price` and
`wrappers needed` of one order does not affect any other order.

### Instructions

Write a program which reads the contents of `input/orders.csv`. Using the promotion rules, your program is to generate
output to a file named `output/redemptions.csv`. Each line in `input/orders.csv` is to result in a line in
`output/redemptions.csv`. Each line in the output file should have the format:

    milk N, dark N, white N, sugar free N

Where `N` is the number of chocolates of that type they possess at the conclusion of all possible trades. You
are to assume that all shoppers trade everything they can and therefore redeem as much chocolate as they possibly can.
