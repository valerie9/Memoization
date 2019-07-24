/**
 * This file includes the test to test the JavaScript method "memoize" to memoize the results of a function. The test function is "addToTime".
 * Another possibility to test memoization would be Fibonacci Numbers but this wasn't tested here.
 *
 * @author Valérie Peter
 * @date 7/23/2019
 */
const memoization = require('../at.fhv.vp.memoization.main/memoizaton');
const expect = require('chai').expect;
const assert = require('assert');
const sinon = require('sinon');


function addToTime(year, month, day) {
    return Date.now() + Date(year, month, day);
}

function fibonacci(x) {
    if (x === 0) {
        return 0;
    } else if (x === 1) {
        return 1;
    }
    return fibonacci(x - 1) + fibonacci(x - 2);
}

/**
 *This includes the sample test which was included in the specification as well as the "addToTime" test.
 *The function could have been tested  with https://sinonjs.org/releases/v6.1.5/fake-timers/ to fake timeouts.
 */
describe('memoization tests', function () {
    it('sampletest', function () {
        let returnValue = 5;
        const testFunction = (key) => returnValue;

        const memoized = memoization.memoize(testFunction, (key) => key, 1000);
        expect(memoized('c544d3ae-a72d-4755-8ce5-d25db415b7764')).to.equal(5);

        returnValue = 10;
    });

    /**
     * The function is applied four times with the same parameters.
     * The results are saved and printed in the console. The first two results and the last two results should be the same.
     * After a timeout of 1000 milliseconds the entry is deleted from the map. That's why
     * the last two results have different values.
     */
    it('memoizeTime', function (done) {
        const resolverFunction = (year, month, day) => year + month + day;
        const memoized = memoization.memoize(addToTime, resolverFunction, 900);
        const result1 = memoized(2019, 7, 22);
        console.log(result1);
        const result2 = memoized(2019, 7, 22);
        console.log(result2);
        console.log('waiting');
        setTimeout(function () {
            const result3 = memoized(2019, 7, 22);
            console.log(result3);
            const result4 = memoized(2019, 7, 22);
            console.log(result4);
            expect(result1).to.equal(result2);
            expect(result3).to.equal(result4);
            expect(result1).to.not.equal(result3);
            done();
        }, 1000)
    });
})

