package server.DAO.Impl;

import entity.Response;
import entity.StudentCase;
import entity.User;
import server.DAO.ServerDAO;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ServerDAOImpl implements ServerDAO {
    private final String PATH_STUDENTS = "src/main/resources/archive_students.xml";
    private final String PATH_USERS = "src/main/resources/users.xml";

    @Override
    public Response getStudentCases() {
        List<StudentCase> studentCases = new ArrayList<>();
        XMLDecoder decoder = null;
        try{
            decoder = new XMLDecoder(
                    new BufferedInputStream(
                            new FileInputStream(PATH_STUDENTS)));
            Object result;
            do{
                result = decoder.readObject();
                studentCases.add((StudentCase) result);
            }
            while(result != null);

        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        catch (ArrayIndexOutOfBoundsException ignored){
            //end of file
        }finally {
            decoder.close();
        }
        Response response = new Response();
        response.setBody(studentCases);
        return response;
    }

    @Override
    public void editStudentCase(int caseId) {

    }

    @Override
    public void createStudentCase(StudentCase studentCase) {

    }

    @Override
    public Response getStudentCaseById(int caseId) {
        return null;
    }

    @Override
    public void login(User user) {

    }

    @Override
    public void signIn(User user) {

    }

    @Override
    public void saveStudentCases(List<StudentCase> list) {
        try {
            XMLEncoder encoder = new XMLEncoder(
                    new BufferedOutputStream(
                            new FileOutputStream(PATH_STUDENTS)));
            for (StudentCase studentCase : list) {
                encoder.writeObject(studentCase);
            }
            encoder.close();
        }
        catch (ArrayIndexOutOfBoundsException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUsersList(List<User> list) {
        try {
            XMLEncoder encoder = new XMLEncoder(
                    new BufferedOutputStream(
                            new FileOutputStream(PATH_USERS)));
            for (User user : list) {
                encoder.writeObject(user);
            }
            encoder.close();
        }
        catch (ArrayIndexOutOfBoundsException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
