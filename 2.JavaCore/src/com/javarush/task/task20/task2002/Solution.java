package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("1.txt", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            User user1 = new User();
            user1.setFirstName("Vasa");
            user1.setLastName("Vasechkin");
            user1.setBirthDate(new Date());
            user1.setMale(true);
            user1.setCountry(User.Country.RUSSIA);
            User user2 = new User();
            user2.setFirstName("Dasha");
            user2.setLastName("Dashechkina");
            user2.setBirthDate(new Date());
            user2.setMale(false);
            user2.setCountry(User.Country.UKRAINE);
            javaRush.users.add(user1);
            javaRush.users.add(user2);
            
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            if (loadedObject.equals(javaRush)) {
                System.out.println(true);
            }

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            if (users.size() == 0) {
                outputStream.write("NULL".getBytes());
            } else {
                for (User user : users) {
                    outputStream.write(user.getFirstName().getBytes());
                    outputStream.write(";".getBytes());
                    outputStream.write(user.getLastName().getBytes());
                    outputStream.write(";".getBytes());
                    outputStream.write(Long.toString(user.getBirthDate().getTime()).getBytes());
                    outputStream.write(";".getBytes());
                    outputStream.write(Boolean.toString(user.isMale()).getBytes());
                    outputStream.write(";".getBytes());
                    outputStream.write(user.getCountry().getDisplayName().getBytes());
                    outputStream.write(System.lineSeparator().getBytes());
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready()) {
                String input = reader.readLine();
                User user = new User();
                if (input.equals("NULL")) {
                    break;
                }
                String[] userParams = input.split(";");
                user.setFirstName(userParams[0]);
                user.setLastName(userParams[1]);
                user.setBirthDate(new Date(Long.parseLong(userParams[2])));
                user.setMale(Boolean.parseBoolean(userParams[3]));
                user.setCountry(User.Country.valueOf(userParams[4].toUpperCase()));
                
                users.add(user);
            }
            reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
