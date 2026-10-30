package ir.maktabsharif.jpa.repositories.base;

import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;

public interface Page<T> {

    List<T> content();

    Pageable pageable();

    long totalElements();

    @RequiredArgsConstructor
    class PageImpl<T> implements Page<T> {

        private final List<T> content;
        private final Pageable pageable;
        private final long totalElements;

        @Override
        public List<T> content() {
            return this.content;
        }

        @Override
        public Pageable pageable() {
            return this.pageable;
        }

        @Override
        public long totalElements() {
            return this.totalElements;
        }

        public static <T> Page<T> empty() {
            return new PageImpl<>(
                    Collections.emptyList(), Pageable.DEFAULT, 0
            );
        }

        public static <T> Page<T> empty(Pageable pageable) {
            return new PageImpl<>(
                    Collections.emptyList(), pageable, 0
            );
        }
    }
}
