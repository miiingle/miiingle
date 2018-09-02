/**
 * Triggered by a change to a Firebase Auth user object.
 *
 * @param {!Object} event Event payload and metadata.
 * @param {!Function} callback Callback function to signal completion.
 */
exports.onAuthCreate = (event, context, callback) => {

    console.log("event: " + Object.keys(event));
    // The unique id of the user whose auth record changed
    const uid = event.uid;
    // log out the uid that caused the function to be triggered
    console.log('Function triggered by change to user: ' +  uid);
    // now log the full event object
    console.log(JSON.stringify(event));
    console.log(JSON.stringify(context));

    callback(undefined, 'Success');
};