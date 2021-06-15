let currentStep = 0;

function goToPreviousStep () {
    setStep (currentStep - 1);
}

function goToNextStep () {
    setStep (currentStep + 1);
}

function setStep (newStep) {
    let oldStep = currentStep;
    currentStep = newStep;
    let steps = $(".step.bordered");
    steps.eq (oldStep).hide ();
    steps.eq (currentStep).show ();
    updateButtons ();
    updateActiveStep (oldStep, currentStep);
}

function updateButtons () {
    let stepCount = $(".step.bordered").length;
    if (currentStep === 0) {
        $("#previous-step").hide ();
        $("#next-step").show ();
        $("#login-button").hide ();
    } else if (currentStep === stepCount - 1) {
        $("#previous-step").show ();
        $("#next-step").hide ();
        $("#login-button").show ();
    } else {
        $("#previous-step").show ();
        $("#next-step").show ();
        $("#login-button").hide ();
    }
}

function updateActiveStep (oldStep, newStep) {
    let steps = $("#progress-bar li");
    steps.eq (oldStep).removeClass ("active");
    steps.eq (newStep).addClass ("active");
}

function init () {
    let steps = $(".step.bordered");
    for (let i = 1; i < steps.length; ++i) {
        let step = steps.eq (i);
        step.hide ();
    }
    updateButtons ();
}

init ();
$("#previous-step").click (() => goToPreviousStep());
$("#next-step").click (() => goToNextStep());