package SKYROM.com.example.SKYROM.entity.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter 
    @Setter 
    public class PaginationResponse<T> implements Serializable {
        private List<T> content;
        private Pagination pagination;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Pagination implements Serializable {
            private long total;
            private int limit;
            private int page;
            private int pages;
        }
    }

