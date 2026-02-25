# Testing with JUnit

You can work in pairs for this lab.

## Learning Goals

* Gain practice writing and running `JUnit` test cases and learn to unit test your code.
* Play a bit with implementing variants of singly linked lists.

## Key Terms and Concepts

* `JUnit` - A unit testing framework where tests are written for each method in a class, each with their own assertions about what the result should be in order to test cases (See [documentation](https://junit.org/junit5/) for more).

After importing the appropriate `JUnit` classes, you may label methods `@BeforeEach` (run before each test) or `@Test` (specific test) and test your code by clicking on the beaker icon in VSCode.

## JUnit

A "unit" test is a test that tests a very small, portion of code, often some functionality of a single method. `JUnit` is a framework that allows you to write meaningful unit tests in Java, run them regularly and easily identify which parts of your Java code might be problematic.

To get started, we have provided you with a starter file where you will write your `JUnit` tests. The file is `SinglyLinkedListTest`. Note that you might need to add `JUnit` 5 to your build path; check with the instructor or the TAs if you need help.

A unit testing class is like a normal Java class, however, it does not have a constructor and the methods that we write are treated as tests. Tests are `public void` methods that are annotated above the method with `@Test`. We then can use special method assertion calls inside these methods that check to see that answers are what we expect them to be. These are called `assert` statements, because they assert what we think should be true if everything is functioning properly. Please note that `JUnit` tests are tested independently of each other so you should not assume a certain order or interdepency of execution. If you need to set up some code that is repeatedly needed in the majority or all of your tests, use the `@BeforeEach` annotation

There are four common assert statements you will use:

* `assertTrue`: takes a single parameter that is a `boolean` expression and checks to make sure that it evaluates to `true`. If it instead evaluates to `false`, then the test that contains the assert statement will fail.

* `assertFalse`: just like `assertTrue` except the test passes if the `boolean` expression evaluates to `false` and fails if it evaluates to `true`.

* `assertEquals`: takes two parameters and checks to make sure that they are equal to each other (based on the overridden `equals` method inherited from `Object` by all classes). If they are not, then the test that contains the assert statement will fail.

* `assertThrows`: tests a method which throws an exception. The general syntax is:

```java
@Test
void testExpectedException(){
    assertThrows(NameOfException.class, () -> {
        //Code under test
    });
}
```

We provided you with a `SinglyLinkedListTest` class that contains a number of `JUnit` tests that show examples of how you can use the above assertions to test our implementation of the `SinglyLinkedList` class. To run these tests, just move to the Testing view (under the `...` on the left panel) and click on the the run arrow. If you see an error at `@BeforeEach`, you may need to hover over `@BeforeEach` and import the necessary code. When you do, you'll see the `JUnit` window open where the package explorer is (generally on the left) and should see a green icon indicating that your tests passed. If the icon is red, that indicates that one or more of your tests failed. If you want to see all of the individual tests passing, you can click the dropdown menu and you can see the results of the individual tests.

The power of `JUnit` is that you can run these tests over and over again as you add new code. This makes sure that the new things you add didn't break anything that was working already!

## Testing `SinglyLinkedList`

The three `JUnit` tests are a good start, but a good test suite will test all of the functionality of a class. Write additional `JUnit` test cases to test all of the public methods of the `SinglyLinkedList` class.

* You should have at least one test case for each method. Often, for more complicated methods, you should have more than one test method.

* To test the iterator, you should add the following to the top of your `SinglyLinkedListTest.java` file: `import java.util.Iterator;`. Add some integers to the linked list and then access its iterator by `Iterator<Integer> list_iterator = l.iterator();` Then you can call the `hasNext()` and `next()` on the `list_iterator` and test them.

* Your test cases should try hard to just isolate the one method that you're testing. This isn't always possible (e.g., in the case of `testAdd`, but you should minimize the number of methods that you call in a test). The goal of a `JUnit` test is to try and precisely as possible isolate where the issue is.

* As you write your test cases, think about edge cases, e.g., when the singly linked list is empty.

Once you have a reasonable test suite, compare your tests with another group in the lab.

* How similar are your tests?

* Were there any cases that you tested that the other group didn't (and vice versa)?

## When you're done

Add JavaDoc to your `JUnit` test cases and do a final commit of both your new `SinglyLinkedList` class and the `JUnit` tests to GitHub. Find a TA to get checked off for 3 points (1 point for code completion, 1 point for style/JavaDocs, and 1 point for this week's [exit ticket](https://forms.gle/W69NsvE39NYcW4GA7)).
