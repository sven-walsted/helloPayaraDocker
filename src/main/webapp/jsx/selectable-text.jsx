const React = require('react')
const ReactDOM = require('react-dom')

const SelectableText = (props) =>
    <span className='pointer'
        onClick={() => { props.handleSelectRecord(props.record) }} >
        {props.text}
    </span>;

module.exports = SelectableText