package org.infinispan.query.dsl.embedded.impl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;

import org.infinispan.AdvancedCache;
import org.infinispan.commons.util.CloseableIterator;
import org.infinispan.objectfilter.ObjectFilter;
import org.infinispan.query.dsl.QueryFactory;

/**
 * A query that does not return any results because the query filter is a boolean contradiction.
 *
 * @author anistor@redhat.com
 * @since 8.0
 */
final class EmptyResultQuery extends BaseEmbeddedQuery {

   EmptyResultQuery(QueryFactory queryFactory, AdvancedCache<?, ?> cache, String jpaQuery, Map<String, Object> namedParameters,
                    long startOffset, int maxResults) {
      super(queryFactory, cache, jpaQuery, namedParameters, null, startOffset, maxResults);
   }

   @Override
   protected Comparator<Comparable[]> getComparator() {
      return null;
   }

   @Override
   protected CloseableIterator<ObjectFilter.FilterResult> getIterator() {
      return new CloseableIterator<ObjectFilter.FilterResult>() {

         @Override
         public void close() {
         }

         @Override
         public boolean hasNext() {
            return false;
         }

         @Override
         public ObjectFilter.FilterResult next() {
            throw new NoSuchElementException();
         }
      };
   }

   @Override
   public String toString() {
      return "EmptyResultQuery{" +
            "jpaQuery=" + jpaQuery +
            ", namedParameters=" + namedParameters +
            ", projection=" + Arrays.toString(projection) +
            ", startOffset=" + startOffset +
            ", maxResults=" + maxResults +
            '}';
   }
}
