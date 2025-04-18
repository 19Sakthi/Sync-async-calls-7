package com.Verinite.StudentConsumer.utility;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ResponseInfo{
    String Message;
    String status;
}
