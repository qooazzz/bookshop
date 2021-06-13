package cn.edu.gdpu;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "发送错误了", value = HttpStatus.NOT_ACCEPTABLE)
public class MyException extends RuntimeException
{

}
