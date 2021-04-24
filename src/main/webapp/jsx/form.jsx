const React = require('react')
const ReactDOM = require('react-dom')

const Button = require('./stateless-button.jsx')

class Form extends React.Component {
    constructor(props) {
        super(props)
    }
    render() {
        return (
            <form>
                <div className="grid-item">
                    <label htmlFor='commonName'>Common Name</label>
                    <input type='text'
                        name='commonName'
                        onChange={this.props.handleCommonChange}
                        value={this.props.commonName} />
                </div>
                <div className="grid-item">
                    <label htmlFor='orderName'>Order</label>
                    <input type='text'
                        name='orderName'
                        onChange={this.props.handleOrderChange}
                        value={this.props.orderName} />
                </div>
                <div className="grid-item">
                    <label htmlFor='className'>Class</label>
                    <input type='text'
                        name='className'
                        onChange={this.props.handleClassChange}
                        value={this.props.className} />
                </div>
                <div className="grid-item">
                    <label htmlFor='familyName'>Family</label>
                    <input type='text'
                        name='familyName'
                        onChange={this.props.handleFamilyChange}
                        value={this.props.familyName} />
                </div>
                <div className="grid-item">
                    <label htmlFor='genusName'>Genus</label>
                    <input type='text'
                        name='genusName'
                        onChange={this.props.handleGenusChange}
                        value={this.props.genusName} />
                </div>
                <div className="grid-item">
                    <label htmlFor='speciesName'>Species</label>
                    <input type='text'
                        name='speciesName'
                        onChange={this.props.handleSpeciesChange}
                        value={this.props.speciesName} />
                </div>
                <Button handleClick={this.props.handleCancelClick} buttonLabel='Cancel' />
                <Button handleClick={this.props.handleSaveClick} buttonLabel='Save' />
            </form>
        );
    }

}

module.exports = Form