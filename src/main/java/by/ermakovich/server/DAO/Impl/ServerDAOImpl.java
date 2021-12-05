package by.ermakovich.server.DAO.Impl;

import by.ermakovich.entity.Response;
import by.ermakovich.entity.StudentCase;
import by.ermakovich.entity.User;
import by.ermakovich.server.DAO.ServerDAO;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public Response editStudentCase(StudentCase studentCase) {
        List<StudentCase> studentCases = new ArrayList<>();
        XMLDecoder decoder = null;
        try{
            decoder = new XMLDecoder(
                    new BufferedInputStream(
                            new FileInputStream(PATH_STUDENTS)));
            StudentCase result;
            do{
                result = (StudentCase) decoder.readObject();
                if (result.getId() == studentCase.getId()){
                    studentCases.add(studentCase);
                }
                else{
                    studentCases.add(result);
                }

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
        saveStudentCases(studentCases);

        Response response = new Response();
        response.setBody(true);
        return response;
    }

    @Override
    public Response createStudentCase(StudentCase studentCase) {
        Response tmp = getStudentCases();
        List<StudentCase> cases = (List<StudentCase>) tmp.getBody();
        cases.add(studentCase);

        saveStudentCases(cases);
        return new Response(true, true);
    }

    @Override
    public Response getStudentCaseById(String caseId) {
        XMLDecoder decoder = null;
        try{
            decoder = new XMLDecoder(
                    new BufferedInputStream(
                            new FileInputStream(PATH_STUDENTS)));
            StudentCase result;
            do{
                result = (StudentCase)decoder.readObject();
                if (Objects.equals(result.getId(), caseId))
                    return new Response( result, true);

            }
            while(result != null);

        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
            return new Response(null, false);
        }
        catch (ArrayIndexOutOfBoundsException ignored){
            //end of file
        }finally {
            decoder.close();
        }
        return new Response(null, true);
    }

    @Override
    public Response login(User user) {
        XMLDecoder decoder = null;
        try{
            decoder = new XMLDecoder(
                    new BufferedInputStream(
                            new FileInputStream(PATH_USERS)));
            User result;
            do{
                result = (User) decoder.readObject();
                if (result.getLogin().equals(user.getLogin()) && result.getHashPassword() == user.getHashPassword()) {
                    return new Response(result, true);
                }

            }
            while(result != null);

        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        catch (ArrayIndexOutOfBoundsException ignored) {
            //end of file
            return new Response(null, true);
        }
        finally {
            decoder.close();
        }
        return new Response(null, false);
    }

    @Override
    public Response signIn(User user) {
        List<User> users = new ArrayList<>();
        XMLDecoder decoder = null;
        try{
            decoder = new XMLDecoder(
                    new BufferedInputStream(
                            new FileInputStream(PATH_USERS)));
            User result;
            do{
                result = (User)decoder.readObject();
                if (result.getLogin().equals(user.getLogin()) && result.getHashPassword() == user.getHashPassword()){
                    return new Response (null, true);
                }
                users.add(result);
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
        users.add(user);
        saveUsersList(users);

        Response response = new Response(user, true);
        return response;
    }

    @Override
    public Response getUsers() {
        List<User> users = new ArrayList<>();
        try (XMLDecoder decoder = new XMLDecoder(
                new BufferedInputStream(
                        new FileInputStream(PATH_USERS)))) {
            User result;
            do {
                result = (User) decoder.readObject();
                users.add(result);
            }
            while (result != null);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (ArrayIndexOutOfBoundsException ignored) {
            //end of file
            return new Response(users, true);
        }
        return new Response(null, false);
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
