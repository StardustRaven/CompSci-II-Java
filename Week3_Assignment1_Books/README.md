# Week 3 – Assignment 1: Book and Textbook

**Name:** Summer Star Isakson  
**Course:** Computer Science II (Java)  
**Date:** 2026-01-22  

## Description
This assignment demonstrates the use of **inheritance** and **polymorphism** in Java.

A base class `Book` is defined with fields for title, author, and number of pages.  
A subclass `Textbook` extends `Book` by adding a recommended grade level.

The program allows the user to:
- Enter multiple books interactively
- Specify whether each book is a pleasure book or a textbook
- Store all entries in an `ArrayList<Book>`
- Display all books after input is complete

Polymorphism is used so both `Book` and `Textbook` objects are handled through a common `Book` reference.

## Files Included
- `Book.java` – Base class containing title, author, and page count
- `Textbook.java` – Subclass extending `Book` with grade level
- `DemoBook.java` – Driver program with user input and output logic

## Concepts Demonstrated
- Inheritance
- Polymorphism
- Constructors
- Accessor and mutator methods
- `ArrayList`
- User input with `Scanner`
- Type casting and `instanceof`

## How to Run
Compile and run `DemoBook.java`.  
Follow the prompts to enter book information, then view the formatted output list.