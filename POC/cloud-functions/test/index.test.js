// unit testing guide:
//https://firebase.google.com/docs/functions/unit-testing

const myFunctions = require('../index.js');
const wrapped = myFunctions.onAuthCreate;

const event = {
    "displayName":"Lyndon Michael Bibera",
    "metadata":{
        "createdAt":"2018-08-31T02:08:26Z",
        "lastSignedInAt":"2018-08-31T02:08:26Z"
    },
    "photoURL":"https://lh5.googleusercontent.com/-ZCPrfofwm-E/AAAAAAAAAAI/AAAAAAAAAAA/APUIFaNr8Ki76L0RwWDJeme6pcn_U5AQUA/mo/photo.jpg",
    "providerData":[
        {
            "displayName":"Lyndon Michael Bibera",
            "photoURL":"https://lh5.googleusercontent.com/-ZCPrfofwm-E/AAAAAAAAAAI/AAAAAAAAAAA/APUIFaNr8Ki76L0RwWDJeme6pcn_U5AQUA/mo/photo.jpg",
            "providerId":"google.com",
            "uid":"116423874706703016596"
        }
        ],
    "uid":"rNTBJhYcPoIS6QPYB2njh44i7rrclW2"
};

const context = {
    "eventId":"c88179e7-2f43-44bf-ba7a-39484",
    "eventType":"providers/firebase.auth/eventTypes/user.create",
    "notSupported":{},
    "resource":"projects/project-net",
    "timestamp":"2018-08-31T02:54:56.848Z"
};

var assert = require('chai').assert;

var error;
var message;

wrapped(event, context, (err, msg) => {
    console.log('executed(' + err + ", " + msg + ')');
    error = err;
    message = msg;
});

console.log('message=' + message);

describe('Cloud Functions', function() {
    describe('#onAuthCreate()', function() {
        it('should not have an error', function() {
            assert.isUndefined(error, 'no error');
        });

        it('should have a success message', function () {
            assert.equal(message, 'Success');
        })
    });
});

