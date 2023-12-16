
// # Assignment 1: GrayscaleImage
//
//The purpose of this assignment is to review some basic Java programming.
//
//WARNING 1:  There are a lot of details in this and all CS 6012 assignment specifications.  Make sure you read this entire description completely and carefully before you begin programming.
//
//WARNING 2:  If you need a refresher on 2D arrays in Java, here's a resource I found via google: https://math.hws.edu/javanotes/c7/s6.html
//
//## Grayscale Images
//
//In this assignment you will complete a partial implementation of a class that represents a grayscale image.  We're representing the image as a 2D array of doubles.  The array entry at `[0][0]` is the top left corner of the image, and the entry at `[height -1][width -1]` is the bottom right pixel.  Each array element stores the brightness of the pixel ranging from black (0) to white(255).
//
//Download the starter code: [GrayscaleImage.java](GrayscaleImage.java) , which has been started for you.
//
//**Notice that this file should be in a new assign01 package that you create in your IDE.**
//
//Complete the GrayscaleImage class providing code where indicated by `// STUDENT: . . .`  comments.  Do not change any of the supplied code including file names, class names, package names, or method names/signatures, with one exception.  After you have provided code where indicated by // STUDENT: . . .  comments, you should remove such comments so your final code is "clean".
//
//WARNING 3: Do not make any of the variables or methods in the GrayscaleImage class static.  This class represents a GrayscaleImage object.  To execute any of the methods, you must call them on an instance of the GrayscaleImage class.  For example,
//
//```
//// Creates a 2x3 image
//GrayscaleImage pic = new GrayscaleImage(new double[][]{{1, 1},{2,2}});
//```
//
//If you are unsure how to use the methods in the class, you may also look at the provided tests for examples of how the operations should work (see below).
//
//### Testing
//
//Download GrayscaleImageTest.java Download [GrayscaleImageTest.java](GrayscaleImageTest.java), which has been started for you.
//
//When your completed GrayscaleImage class passes all of these provided tests, add many more JUnit 5 tests to ensure that it is working correctly.
//
//Consider all of the cases and code paths so far unevaluated by the provided tests.  A portion of your Assignment 1 score depends on the completeness and robustness of the extended GrayscaleImageTest.java file that you submit.
//
//Note: If a method is marked as possibly throwing an exception, you should add a test verifying that it does when appropriate!
//
//
//## Cropper Tool
//
//As an example of what you might use this class for, the provided Cropper program: [Cropper.java](Cropper.java) is provided to you.  If you add it to your project and run it, it will prompt you for an image url (try this URL: https://www.utah.edu/_resources/images/visitors/banner-visitor.jpg), and will download it, edit it using the GrayscaleImage class operations, and save it to a file named outputImage.png.  You are not required to use this tool, but it will show you visually what your code does to a real image.
//
//## Style and design
//
//Use good coding style and design your solution clearly, such that experienced programmers like the TAs will have no problem reading your code.  Use good variable names, consistent formatting, and adequate (but not excessive) comments.
//
//A portion of your Assignment 1 score depends on the style and design of the GrayscaleImage and GrayscaleImageTest classes you submit.  You may add additional methods if you'd like.  Do not forget to replace any instructional comments before submission (e.g., @author Ben Jones and ??, // STUDENT: ...).
//
//We'll evaluate these parts of yoru grade during code review (participation in reviews is also part of yoru grade)
//
//## Submission
//
//Your solution for this assignment consists of two files: GrayscaleImage.java and GrayscaleImageTest.java, which are your filled-in/extended versions of the files provided above.
//
//You'll submit these files in 2 places.  First, commit them to your repo.  We'll look at your repos during code review.
//
//Second, we'll submit to just the GrayscaleImage.java file to Gradescope which will compile your code and run an autograder.
//
//You can access Gradescope from the sidebar menu from Canvas.
//
//In Gradescope, click on Assignment 1: GrayscaleImage.  Leave Submission Method set to the default — Upload.  Drag-and-drop or browse to select exactly the Java file you'll be submitting: GrayscaleImage.java.  Do not submit a folder or a .zip file.  Click Upload.
//
//The auto-grader is set to run the tests already provided to you in GrayscaleImageTest.java, as soon as you submit and before the assignment deadline.  Among other things, running these tests early ensures the following:
//
//* You have correctly navigated the Gradescope submission process.
//* You have the correct assign01 package declaration in both files.
//* You have not introduced any typos or other errors in the naming of your GrayscaleImage class and methods.
//* You are not submitting the versions of these files we provided to you, without the method stubs filled in.
//
//Running these tests could take a few minutes.  Your results will show when the page updates.  If you have failed any of the tests, be sure to correct your code and resubmit.  Note that passing these "pre-tests" is only part of your assignment 1 grade.  The remaining points will be assessed after the assignment deadline and based on whether your code passes "post-tests" which aren't visible until after the due date, as well as what we discuss during code review.
//
//As explained above, you should do much more extensive testing of your code than in these seven provided tests.  Note that the auto-grader does not run the GrayscaleImageTest file that you upload, but you must upload it so that the TAs can easily see the quality and coverage of your JUnit 5 tests.
//
//In addition to the autograder scores, we'll also do group code review for Assignment 1.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}