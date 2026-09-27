package thanhdnh.ueh.edu.article_app;

public class UserData {

    public static UserList createUserList() {

        UserList userList = new UserList();

        // =====================================================
        // USER 1
        // =====================================================

        userList.addUser(
                new UserProfile(
                        "U001",

                        "User 1",

                        "user1@gmail.com",

                        "Sinh viên yêu thích công nghệ, "
                                + "lập trình và các ứng dụng di động.",

                        // Chỉ lưu đường dẫn ảnh
                        "drawable/avatar_user1",

                        "Football, Music, Coding"
                )
        );

        // =====================================================
        // USER 2
        // =====================================================

        userList.addUser(
                new UserProfile(
                        "U002",

                        "User 2",

                        "user2@gmail.com",

                        "Sinh viên yêu thích thiết kế, "
                                + "nhiếp ảnh và sáng tạo nội dung.",

                        // Chỉ lưu đường dẫn ảnh
                        "drawable/avatar_user2",

                        "Photography, Design, Travel"
                )
        );

        // =====================================================
        // USER 3
        // =====================================================

        userList.addUser(
                new UserProfile(
                        "U003",

                        "User 3",

                        "user3@gmail.com",

                        "Yêu thích nghiên cứu trí tuệ nhân tạo "
                                + "và khoa học dữ liệu.",

                        // Chỉ lưu đường dẫn ảnh
                        "drawable/avatar_user3",

                        "AI, Data, Reading"
                )
        );

        // =====================================================
        // USER 4
        // =====================================================

        userList.addUser(
                new UserProfile(
                        "U004",

                        "User 4",

                        "user4@gmail.com",

                        "Quan tâm đến phát triển phần mềm "
                                + "và công nghệ web.",

                        // Chỉ lưu đường dẫn ảnh
                        "drawable/avatar_user4",

                        "Web, Gaming, Music"
                )
        );

        return userList;
    }
}