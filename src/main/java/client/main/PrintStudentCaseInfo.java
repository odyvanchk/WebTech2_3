package client.main;

import entity.StudentCase;

import java.util.List;

public class PrintStudentCaseInfo {

    public static void print(List<StudentCase> cases) {
        for (StudentCase studentCase: cases) {
            System.out.println(studentCase.toString());
        }

    }
}
