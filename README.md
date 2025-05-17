# Finite Automata Simulator

![Java](https://img.shields.io/badge/Java-17-blue)
![Automata](https://img.shields.io/badge/Finite_Automata-DFA/NFA-green)

A Java implementation of Deterministic and Non-deterministic Finite Automata with 10 practical pattern recognition solutions.

## Key Features

### Deterministic Finite Automata (DFA)
1. **Odd 'a' Counter** - Accepts strings over {a,b} with odd number of 'a's
2. **Binary Pattern Matcher** - Recognizes binary strings starting with 1 (length ≥3)
3. **Substring Detector** - Identifies strings containing "xyz" substring
4. **Divisibility Checker** - Validates binary numbers divisible by 7
5. **Pair Validator** - Checks for consecutive 'a's appearing in pairs
6. **Dual Parity Check** - Matches strings with even 'a's and odd 'b's

### Non-deterministic Finite Automata (NFA)
7. **Binary Constraint Check** - Validates strings with both 0 and 1, max 2 consecutive digits
8. **Multiple Occurrence Finder** - Detects at least two "ab" substrings
9. **Follow Pattern Validator** - Ensures every '1' is followed by ≤1 '0'
10. **Non-consecutive Filter** - Accepts strings where no two 'y's appear consecutively

## Implementation Details

- **Core Engine**: 
  - `DFA` class with state transition logic
  - `NFA` class with non-deterministic path handling
- **Pattern Recognition**: Each solution implements specific transition tables
- **Input/Output**: Processes text files with test cases and writes results



## Contributors

We would like to thank the following contributors to this project:

- [**Shahd Osama**](https://github.com/shahdosama10).
- [**Ahmed Saad**](https://github.com/ahmedsaad123456).
- [**Ahmed Adel**](https://github.com/Dola112).
