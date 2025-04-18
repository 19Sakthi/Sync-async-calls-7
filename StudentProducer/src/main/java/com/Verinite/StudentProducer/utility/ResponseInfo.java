package com.Verinite.StudentProducer.utility;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ResponseInfo{
    String Message;
    String status;
}
