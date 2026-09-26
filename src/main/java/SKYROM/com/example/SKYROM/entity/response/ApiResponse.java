package SKYROM.com.example.SKYROM.entity.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<P extends Serializable> implements Serializable {

    private String message;
    private P payload;
    private boolean success;

    public static <P extends Serializable> ApiResponse<P> ok(P payload) {
        return new ApiResponse<>(StringUtils.EMPTY, payload, true);
    }
}
