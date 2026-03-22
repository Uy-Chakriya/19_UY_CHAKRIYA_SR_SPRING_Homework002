package org.chakriya._9_uy_chakriya_sr_web_homework002.model.respones;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse<T> {
    private Boolean success;
    private HttpStatus status;
    private String message;
    private T payload;
    private Instant timestamp;
}