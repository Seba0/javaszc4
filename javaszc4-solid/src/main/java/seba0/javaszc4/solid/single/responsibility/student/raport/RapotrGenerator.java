package seba0.javaszc4.solid.single.responsibility.student.raport;

import seba0.javaszc4.solid.single.responsibility.student.Student;

import java.io.PrintStream;
import java.util.Map;

public class RapotrGenerator {

    public static void generate(Student student, PrintStream out) {
        out.println("=============== SCORES RAPORT ===============");
        out.println("   Name: " + student.getName() + " Age: " + student.getAge());
        out.println("   Email: " + student.getEmail());
        out.println();
        out.println("SCORES:");
        for (Map.Entry<String, Integer> score : student.getScores().entrySet()) {
            out.println("   " + score.getKey() + ": " + score.getKey());
        }
        out.println("=============================================");
    }
}
