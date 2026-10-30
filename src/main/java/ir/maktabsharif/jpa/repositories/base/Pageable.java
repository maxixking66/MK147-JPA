package ir.maktabsharif.jpa.repositories.base;

import lombok.RequiredArgsConstructor;

public interface Pageable {

    int size();

    int page();

    default int offset() {
        return size() * page();
    }

    PageRequest DEFAULT = new PageRequest(0, 10);

    @RequiredArgsConstructor
    class PageRequest implements Pageable {
        private final int page;
        private final int size;

        @Override
        public int size() {
            return this.size;
        }

        @Override
        public int page() {
            return this.page;
        }
    }
}
