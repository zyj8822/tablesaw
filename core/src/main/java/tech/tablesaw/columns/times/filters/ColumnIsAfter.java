/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tech.tablesaw.columns.times.filters;

import tech.tablesaw.api.TimeColumn;
import tech.tablesaw.columns.Column;
import tech.tablesaw.columns.ColumnReference;
import tech.tablesaw.filtering.TwoColumnFilter;
import tech.tablesaw.selection.Selection;

import static tech.tablesaw.columns.DateAndTimePredicates.isGreaterThan;

/**
 */
public class ColumnIsAfter extends TwoColumnFilter {

    public ColumnIsAfter(ColumnReference reference, Column otherColumn) {
        super(reference, otherColumn);
    }

    public ColumnIsAfter(TimeColumn columnToCompareAgainst) {
        super(columnToCompareAgainst);
    }

    public ColumnIsAfter(ColumnReference reference, ColumnReference columnToCompareAgainst) {
        super(reference, columnToCompareAgainst);
    }

    /**
     * Returns a selection formed by applying a predicate for case-neutral equality between
     * each value in the given column and the corresponding value of the column passed into the constructor.
     *
     * @param columnBeingFiltered The column whose results will be filtered by the operation
     */
    @Override
    public Selection apply(Column columnBeingFiltered) {
        TimeColumn timeColumn = (TimeColumn) columnBeingFiltered;
        return timeColumn.eval(isGreaterThan, (TimeColumn) otherColumn());
    }
}