package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {

    public static final class Constants{
        public static final String SNA="Server is not accessible for now.";
        public static final String UUE="User is not authorized.";
        public static final String BUE="User is banned.";
        public static final String RE="Access is denied.";
    }

    //Constants cn=new Constants();

    public class ServerNotAccessibleException extends Exception {

        public ServerNotAccessibleException() {
            super(Solution.Constants.SNA);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(Solution.Constants.SNA, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(Solution.Constants.UUE);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Solution.Constants.UUE, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(Solution.Constants.BUE);
        }

        public BannedUserException(Throwable cause) {
            super(Solution.Constants.BUE, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(Solution.Constants.RE);
        }

        public RestrictionException(Throwable cause) {
            super(Solution.Constants.RE, cause);
        }
    }
}
